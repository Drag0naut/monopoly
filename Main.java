public static void main(String[] args) {

  Board board;
  Space[] spaces = new Space[40];
  //space position starts at go = 0
  Space mediterraneanAve = new PropertySpace(1, 60, 2, 10, 30, 90, 160, 250, 50, 30);
  Space balticAve = new PropertySpace(3, 60, 4, 20, 60, 180, 320, 450, 50, 30);
  Space orientalAve = new PropertySpace(6, 100, 6, 30, 90, 270, 400, 550, 50, 50);
  Space vermontAve = new PropertySpace(8, 100, 6, 30, 90, 270, 400, 550, 50, 50);
  Space connecticutAve = new PropertySpace(9, 120, 8, 40, 100, 300, 450, 600, 50, 60);
  Space stCharlesPlace = new PropertySpace(11, 140, 10, 50, 150, 450, 625, 750, 100, 70);
  Space statesAve = new PropertySpace(13, 140, 10, 50, 150, 450, 625, 750, 100, 70);
  Space virginaAve = new PropertySpace(14, 160, 12, 60, 180, 500, 700, 900, 100, 80);
  Space stJamesPlace = new PropertySpace(16, 180, 14, 70, 200, 550, 750, 950, 100, 90);
  Space tennesseeAve = new PropertySpace(18, 180, 14, 70, 200, 550, 750, 950, 100, 90);
  Space newYorkAve = new PropertySpace(19, 200, 16, 80, 220, 600, 800, 1000, 100, 100);
  Space kentuckyAve = new PropertySpace(21, 220, 18, 90, 250, 700, 875, 1050, 150, 110);
  Space indianaAve = new PropertySpace(23, 220, 18, 90, 250, 700, 875, 1050, 150, 110);
  Space illinoisAve = new PropertySpace(24, 240, 20, 100, 300, 750, 925, 1100, 150, 120);
  Space atlanticAve = new PropertySpace(26, 260, 22, 110, 330, 800, 975, 1150, 150, 130);
  Space ventnorAve = new PropertySpace(27, 260, 22, 110, 330, 800, 975, 1150, 150, 130);
  Space marvinGardens = new PropertySpace(29, 280, 24, 120, 360, 850, 1025, 1200, 150, 140);
  Space pacificAve = new PropertySpace(31, 300, 26, 130, 390, 900, 1100, 1275, 200, 150);
  Space northCarolinaAve = new PropertySpace(32, 300, 26, 130, 390, 900, 1100, 1275, 200, 150);
  Space pennsylvaniaAve = new PropertySpace(34, 320, 28, 150, 450, 1000, 1200, 1400, 200, 160);
  Space parkPlace = new PropertySpace(37, 350, 35, 175, 500, 1100, 1300, 1500, 200, 175);
  Space boardwalk = new PropertySpace(39, 400, 50, 200, 600, 1400, 1700, 2000, 200, 200);
  spaces = {
    mediterraneanAve, balticAve, orientalAve, vermontAve, connecticutAve, stCharlesPlace, statesAve, virginiaAve,
    stJamesPlace, tennesseeAve, newYorkAve, kentuckyAve, indianaAve, illinoisAve, atlanticAve, ventnorAve, marvinGardens,
    pacificAve, northCarolinaAve, pennsylvaniaAve, parkPlace, boardwalk
  };
  board = new Board(spaces);

}
