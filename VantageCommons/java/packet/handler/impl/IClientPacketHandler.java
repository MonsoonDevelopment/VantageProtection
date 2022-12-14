package packet.handler.impl;

import packet.handler.PacketHandler;
import packet.impl.client.community.ClientCommunityMessageSend;
import packet.impl.client.general.llIIlIlIllllIIllIllIIIIIIlIIIlII;
import packet.impl.client.community.ClientCommunityPopulateRequest;
import packet.impl.client.login.lIIIIIllIIIIlIIIlIIllIlIIlIlIIIl;
import packet.impl.client.protection.lIlIIlllllllIIlllI;
import packet.impl.client.protection.lIlIlIlIIIlllIIlIlIIIlllIIlllIlIIIlllIlI;
import packet.impl.client.protection.lllIIllIlIIlIlllIllIlIIIIIlIlIIl;
import packet.impl.client.store.lIIlIIIIIllIlllllllIIlllIlIllIlI;
import packet.impl.client.store.lllllIIlIIIlIIIIIIIlIlllIlIlIIlI;

public interface IClientPacketHandler extends PacketHandler {
    void handle(final lIIIIIllIIIIlIIIlIIllIlIIlIlIIIl packet);
    void handle(final lIlIIlllllllIIlllI packet);
    void handle(final ClientCommunityMessageSend packet);
    void handle(final lIlIlIlIIIlllIIlIlIIIlllIIlllIlIIIlllIlI packet);
    void handle(final ClientCommunityPopulateRequest packet);

    void handle(final lllllIIlIIIlIIIIIIIlIlllIlIlIIlI packet);

    void handle(final lIIlIIIIIllIlllllllIIlllIlIllIlI packet);

    void handle(final lllIIllIlIIlIlllIllIlIIIIIlIlIIl packet);

    void handle(final llIIlIlIllllIIllIllIIIIIIlIIIlII packet);

}
