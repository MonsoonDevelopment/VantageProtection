package util;

import encryption.impl.AESEncryption;
import encryption.impl.RSAEncryption;
import lombok.Data;
import lombok.Getter;
import packet.Packet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Base64;
import java.util.UUID;

@Getter
public final class Communication {

    private final Socket socket;

    private RSAEncryption rsaEncryption;
    private AESEncryption aesEncryption;

    private ObjectOutputStream output;
    private ObjectInputStream input;

    public Communication(final Socket socket, final boolean server) {
        this.socket = socket;

        try {
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.input = new ObjectInputStream(socket.getInputStream());

            if (server) {
                this.rsaEncryption = new RSAEncryption();

                this.output.writeObject(this.rsaEncryption.getPublicKey());

                this.aesEncryption = new AESEncryption(new String(this.rsaEncryption.decrypt(Base64.getDecoder().decode(this.input.readUTF()))));
            } else {
                this.rsaEncryption = new RSAEncryption(null, (PublicKey) this.input.readObject());

                final String key = UUID.randomUUID().toString().replace("-", "");

                this.aesEncryption = new AESEncryption(key);
                this.output.writeUTF(Base64.getEncoder().encodeToString(this.rsaEncryption.encrypt(key.getBytes(StandardCharsets.UTF_8))));
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void write(final Packet<?> packet) {
        try {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ObjectOutputStream out = new ObjectOutputStream(bos);

            out.writeObject(packet);
            out.flush();

            final EncryptedTraffic traffic = new EncryptedTraffic(this.aesEncryption.encrypt(bos.toByteArray()));

            this.output.writeObject(traffic);
            this.output.reset();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public Packet<?> read() {
        try {
            final EncryptedTraffic traffic = (EncryptedTraffic) this.input.readObject();
            final byte[] data = aesEncryption.decrypt(traffic.getContent());

            final ByteArrayInputStream bis = new ByteArrayInputStream(data);
            final ObjectInputStream ois = new ObjectInputStream(bis);

            return (Packet<?>) ois.readObject();
        } catch (final Exception e) {
            //e.printStackTrace();
        }

        return null;
    }

    @Data
    static class EncryptedTraffic implements Serializable {
        private final byte[] content;
    }
}
