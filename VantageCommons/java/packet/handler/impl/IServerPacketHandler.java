package packet.handler.impl;

import packet.handler.PacketHandler;
import packet.impl.server.community.ServerCommunityMessageSend;
import packet.impl.server.community.ServerCommunityPopulatePacket;
import packet.impl.server.general.llIllllIIIlIIlIIllIlIIIllIIIIIIl;
import packet.impl.server.login.lIIlllIIIllIIIIIllIIIllllIllIllI;
import packet.impl.server.protection.lIllIlIlIlIIIlllIIIlllIIIIlllI;
import packet.impl.server.protection.lIlIIIllIlIIIlllIllI;
import packet.impl.server.protection.lIllIIlllIIIIlIllIIIIllIlllllIll;
import packet.impl.server.store.IllIIIllllIlIlIIIllIlIllllIIllll;

public interface IServerPacketHandler extends PacketHandler {
    void handle(final lIIlllIIIllIIIIIllIIIllllIllIllI packet);

    void handle(final ServerCommunityPopulatePacket packet);

    void handle(final ServerCommunityMessageSend packet);

    void handle(final lIllIlIlIlIIIlllIIIlllIIIIlllI packet);

    void handle(final IllIIIllllIlIlIIIllIlIllllIIllll packet);

    void handle(final lIllIIlllIIIIlIllIIIIllIlllllIll packet);

    void handle(final llIllllIIIlIIlIIllIlIIIllIIIIIIl packet);

    void handle(lIlIIIllIlIIIlllIllI serverConstantResult);
}
