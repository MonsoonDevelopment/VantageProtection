package packet.impl.server.protection;

import lombok.AllArgsConstructor;
import lombok.Data;
import packet.handler.impl.IServerPacketHandler;
import packet.type.ServerPacket;
import util.simpleobjects.lllIIllIlIIlIlllIllIlIIIIIlIlIlI;

import java.util.List;

@Data
@AllArgsConstructor
public final class lIllIIlllIIIIlIllIIIIllIlllllIll implements ServerPacket {

    public List<lllIIllIlIIlIlllIllIlIIIIIlIlIlI> targets;

    @Override
    public void process(final IServerPacketHandler handler) {
        handler.handle(this);
    }
}
