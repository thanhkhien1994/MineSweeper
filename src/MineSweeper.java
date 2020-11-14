/*
* Thực hành mảng hai chiều - tạo bản đồ trò chơi MineSweeper
* */
public class MineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", ".", ".", ".", "*"},
                {".", ".", ".", "*", "*"},
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];

        for (int x = 0; x < MAP_WIDTH; x++) {
            String min = map[0][x];
            /*Nếu là mìn thì tại vị trí đó push mìn vào mảng mới tại vị trí đó.*/
            if (min.equals("*")) mapReport[0][x] = "*";
            else{
                int count = 0;
                /*Nếu bên trái tồn tại và tại vị trí bên trái tức x-1 có mìn thì count++*/
                boolean minNTLeft = x-1>=0;
                boolean minCTLeft = minNTLeft && map[0][x-1].equals("*");
                if (minCTLeft) count ++;
                /*Nếu bên phải tồn tại và tại vị trí bên phải tức x+1 có mìn thì count ++*/
                boolean minNTRight = x+1 < MAP_WIDTH;
                boolean minCTRight = minNTRight && map[0][x+1].equals("*");
                if (minCTRight) count++;
                /*Số mìn được đẩy vào mảng mới haha*/
                mapReport[0][x] = String.valueOf(count);
            }
        }
        /*In ra mảng hiện tại với số mìn xung quanh vị trí cắm cờ*/
        for (int x = 0; x < MAP_WIDTH; x++) {
            String currentReport = mapReport[0][x];
            System.out.print(currentReport);
        }
    }
}
