package org.lukadevrij.pingit.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.lukadevrij.pingit.PingIt;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PingItCommand implements CommandExecutor {
    PingIt plugin;
    public PingItCommand(PingIt plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)){
            sender.sendMessage(Component.text("The console cannot perform this command!"));
            return true;
        }

        Block targetBlock = player.getTargetBlock(getTransparentBlocks(), 128);
        Location targetBlockLocation = targetBlock.getLocation();
        Location playerLocation = player.getEyeLocation();
        Vector direction = playerLocation.getDirection();

        double distance = (playerLocation.distance(targetBlockLocation) / 10) * 8;
        System.out.println(distance);
        // Calculate the new location
        Location particleLocation = playerLocation.add(direction.multiply(distance));

        player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, particleLocation, 100, 0, 0, 0, 0.05, null, true);

        return false;
    }

    public static HashSet<Material> getTransparentBlocks() {
        HashSet<Material> transparentBlocks = new HashSet<>();

        for (Material material : Material.values()) {
            if (!material.isOccluding()) {
                transparentBlocks.add(material);
            }
        }

        return transparentBlocks;
    }
}
