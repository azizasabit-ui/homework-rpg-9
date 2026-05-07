package com.narxoz.rpg.vault;

public class VaultRunResult {
    private final int artifactsAppraised;
    private final int mementosCreated;
    private final int restoredCount;

    public VaultRunResult(int artifactsAppraised, int mementosCreated, int restoredCount) {
        this.artifactsAppraised = artifactsAppraised;
        this.mementosCreated = mementosCreated;
        this.restoredCount = restoredCount;
    }

    public int getArtifactsAppraised() { return artifactsAppraised; }
    public int getMementosCreated() { return mementosCreated; }
    public int getRestoredCount() { return restoredCount; }

    @Override
    public String toString() {
        return "╔════════════════════════════════════════╗\n" +
               "║        VAULT RUN RESULTS               ║\n" +
               "╠════════════════════════════════════════╣\n" +
               "║ Artifacts Appraised: " + String.format("%-12d", artifactsAppraised) + "║\n" +
               "║ Mementos Created:    " + String.format("%-12d", mementosCreated) + "║\n" +
               "║ Restorations Performed: " + String.format("%-8d", restoredCount) + "║\n" +
               "╚════════════════════════════════════════╝";
    }
}