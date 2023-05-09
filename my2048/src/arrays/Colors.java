package arrays;

import java.awt.Color;


public class Colors {
    public Color getTileColor(int tile) {
        switch (tile) {
        case 2:
            return new Color(238, 228, 218); // light yellow
        case 4:
            return new Color(237, 224, 200); // yellow
        case 8:
            return new Color(242, 177, 121); // orange
        case 16:
            return new Color(245, 149, 99); // light orange
        case 32:
            return new Color(246, 124, 95); // red
        case 64:
            return new Color(246, 94, 59); // light red
        case 128:
            return new Color(237, 206, 114); // light green
        case 256:
            return new Color(237, 204, 97); // green
        case 512:
            return new Color(237, 201, 80); // light blue
        case 1024:
            return new Color(237, 197, 63); // blue
        case 2048:
            return new Color(237, 194, 46); // yellow-green
        default:
            return new Color(204, 192, 179); // gray
        }
    }
}
