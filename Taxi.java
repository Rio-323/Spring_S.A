public class Taxi extends PublicTrans{
    String destination;
    int distanceToDest;
    int originDistance = 1;
    int distancePrice = 1000;

    public Taxi(int carNum)
    {
        super.startTrans ( "일반" );
        super.carNum = carNum;
        super.curPassenger = 0;
        super.maxPassenger = 4;
        System.out.println (carNum + "번 택시가 출발합니다.");
        System.out.println ("주유량 : " + super.fuel);
        System.out.println ("상태 : " + super.status);
    }

    public void payment(int distanceToDest)
    {
        int price = (super.price + (distanceToDest - originDistance) * distancePrice);
        System.out.println ("지불할 요금 : " + price);
    }


    @Override
    public void changeStatus()
    {
        super.changeStatus ();
        if(fuel < 10)
        {
            this.status = "차고지행";
        }
    }


}
