package com.starlink.backend.lld.flyweight.paytm;

public class TransactionIcon implements TransactionRenderer {

    // INTRINSIC STATE — shared, immutable, heavy
    private final String status;
    private final String color;
    private final String svgIcon;
    private final String animation;

    // Package-private — sirf factory banayegi
    TransactionIcon(String status, String color, String svgIcon) {
        this.status    = status;
        this.color     = color;
        this.svgIcon   = svgIcon;
        this.animation = loadAnimation(status);

        // Ye line prove karegi ki object sirf ek baar bana
        System.out.println("  [NEW OBJECT CREATED] TransactionIcon: " + status);
    }

    private String loadAnimation(String status) {
        // Heavy operation simulate karo
        try { Thread.sleep(10); } catch (InterruptedException e) {}
        return "anim_" + status + "_v2";
    }

    // EXTRINSIC STATE — bahar se aata hai, andar store nahi
    @Override
    public void render(double amount, String merchant, long timestamp) {
        System.out.printf("  %s  |  color=%-9s  |  Rs.%8.2f  |  %-25s  |  ts=%d%n",
                getStatusBadge(status), color, amount, merchant, timestamp);
    }

    private String getStatusBadge(String status) {
        return switch (status) {
            case "SUCCESS" -> "[SUCCESS]";
            case "FAILED"  -> "[FAILED] ";
            case "PENDING" -> "[PENDING]";
            default        -> "[UNKNOWN]";
        };
    }

    // Debug ke liye
    public String getStatus() { return status; }
}