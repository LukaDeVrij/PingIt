package org.lukadevrij.pingit.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashSet;

public abstract class AbstractPing {
    String type;
    Player owner;

    public AbstractPing(Player owner) {
        this.owner = owner;
    }

    public abstract void createPing();

    public HashSet<Material> getTransparentBlocks() {
        HashSet<Material> transparentBlocks = new HashSet<>();

        for (Material material : Material.values()) {
            if (!material.isOccluding()) {
                transparentBlocks.add(material);
            }
        }

        return transparentBlocks;
    }

}
