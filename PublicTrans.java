public class PublicTrans {
    int carNum;
    int fuel = 100;
    int speed = 0;
    int maxPassenger;
    int curPassenger;
    int price;
    String status;

    public void startTrans(String status)
    {
        this.status = status;
    }

    public void changeStatus()
    {
        if(this.status == "운행" && this.fuel > 10) {
            this.status = "차고지행";
            System.out.println ("차고지행");
        } else if (this.status == "차고지행" && this.fuel > 10) {
            this.status = "운행";
            System.out.println ("운행");
        }
        
        if(fuel <= 10)
        {
            this.status = "차고지행";
            System.out.println ("차고지행");
        }
    }

    public void boardBus(int newPassenger)
    {
        this.maxPassenger = 30;
        if (this.curPassenger + newPassenger <= maxPassenger && status.equals ( "운행" )){
            this.curPassenger += newPassenger;
            System.out.println ("탑승 승객 수 : " + newPassenger);
            System.out.println ("잔여 좌석 : " + (this.maxPassenger - this.curPassenger));
            System.out.println ("요금 확인 : " + price * newPassenger);
        } else if (status.equals ( "차고지행" )) {
            System.out.println ("운행중이 아닙니다.");
        } else if (this.curPassenger + newPassenger > maxPassenger) {
            System.out.println ("최대 승객 수를 초과하였습니다.");
        }
    }

    public void boardTaxi(int newPassenger, String destination, int distanceToDest)
    {
        this.curPassenger = 0;
        this.price = 3000;
        this.maxPassenger = 4;
        int originDistance = 1;
        int distancePrice = 1000;

        if (status.equals ( "일반" ) && newPassenger <= maxPassenger){
            this.curPassenger += newPassenger;
            status = "운행중";
            System.out.println ("탑승 승객 수 : " + newPassenger);
            System.out.println ("잔여 승객 수 : " + (this.maxPassenger - this.curPassenger));
            System.out.println ("기본요금 확인 : " + price);
            System.out.println ("목적지 : " + destination);
            System.out.println ("목적지까지 거리 : " + distanceToDest + "km");
            System.out.println ("지불할 요금 : " + (this.price + (distanceToDest - originDistance) * distancePrice));
            System.out.println ("상태 : " + status);
        } else if (newPassenger > maxPassenger) {
            System.out.println ("최대 승객 수를 초과하였습니다.");
        } else if (status.equals ( "운행중" ) || status.equals ( "차고지행" )) {
            System.out.println ("택시 상태를 확인해주세요!");
        }
    }

    public void setFuel(int fuel)
    {
        if(this.fuel < 10){
            changeStatus ();
            System.out.println ("주유 필요!");
        }
        else {
            System.out.println ("주유량 : " + (this.fuel + fuel));
        }

        this.fuel = (this.fuel + fuel);
    }

    public void changeSpeed(int speed)
    {
        this.speed += speed;
        if(this.fuel > 10 && status.equals ( "운행" ))
        {
            System.out.println ("속도를 변경합니다 : " + this.speed);
        }
    }
}


