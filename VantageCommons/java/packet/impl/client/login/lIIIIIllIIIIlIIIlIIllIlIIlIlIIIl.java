package packet.impl.client.login;

import lombok.Data;
import packet.handler.impl.IClientPacketHandler;
import packet.type.ClientPacket;

@Data
public final class lIIIIIllIIIIlIIIlIIllIlIIlIlIIIl implements ClientPacket {

    private final String email, password, hostName, systemName, osName, hardwareID, clientID;
    @Override
    public void process(final IClientPacketHandler handler) {
        handler.handle(this);
    }
}
