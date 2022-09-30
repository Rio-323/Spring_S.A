public class Bus extends PublicTrans{
    public Bus(int carNum)
    {
        super.startTrans ( "운행" );
        super.carNum = carNum;
        super.maxPassenger = 30;
        super.price = 1000;
        super.curPassenger = 0;
        System.out.println (carNum + "번 버스가 출발합니다.");
    }
}
