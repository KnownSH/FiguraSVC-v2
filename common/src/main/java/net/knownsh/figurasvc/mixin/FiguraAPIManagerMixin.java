package net.knownsh.figurasvc.mixin;

import net.knownsh.figurasvc.voice.VoiceAPI;
import net.knownsh.figurasvc.voice.event.ClientReceiveSoundEventData;
import net.knownsh.figurasvc.voice.event.ClientSoundEventData;
import org.figuramc.figura.lua.FiguraAPIManager;
import org.figuramc.figura.lua.FiguraLuaRuntime;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@Mixin(value = FiguraAPIManager.class, remap = false)
public class FiguraAPIManagerMixin {
    @Shadow
    @Final
    public static Set<Class<?>> WHITELISTED_CLASSES;

    @Shadow
    @Final
    public static Map<String, Function<FiguraLuaRuntime, Object>> API_GETTERS;

    static {
        WHITELISTED_CLASSES.add(VoiceAPI.class);
        WHITELISTED_CLASSES.add(ClientSoundEventData.class);
        WHITELISTED_CLASSES.add(ClientReceiveSoundEventData.class);

        API_GETTERS.put("voice", VoiceAPI::new);
    }
}
