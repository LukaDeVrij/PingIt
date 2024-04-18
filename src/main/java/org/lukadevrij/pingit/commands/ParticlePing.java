package org.lukadevrij.pingit.commands;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ParticlePing extends AbstractPing {

    public ParticlePing(Player owner) {
        super(owner);
        this.type = "particle";
    }

    @Override
    public void createPing() {

        Player player = owner;

        Block targetBlock = player.getTargetBlock(getTransparentBlocks(), 128);
        Location targetBlockLocation = targetBlock.getLocation();
        Location playerLocation = player.getEyeLocation();
        Vector direction = playerLocation.getDirection();

        double distance = (playerLocation.distance(targetBlockLocation) / 10) * 8;
        System.out.println(distance);
        // Calculate the new location
        Location particleLocation = playerLocation.add(direction.multiply(distance));

        player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, particleLocation, 100, 0, 0, 0, 0.05, null, true);

    }
}
