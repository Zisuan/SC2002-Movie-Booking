package Model;

public class Price{ 
    //additional price can be charged according to these factors alongside base price based on age group

    //subject to change, these are placeholder values probably
    //types of movie = [3D, Blockbuster, default], default has no surcharge
    //classes of cinema = [Platinum, Gold, Default], default has no surcharge
    //user age groups = [Senior, Student, Adult] base prices based on age groups
    //day of the week = [Weekday, Weekend/Public Holiday] weekdays(excl. public holidays) have no surcharge
    
    //ticket price= movie type(s) + cinema class + age group + day

    //types of movie
    //surcharge for 3D movie
    private double threeDSurcharge;
    //surcharge for blockbuster movie
    private double blkBusterSurcharge;

    //types of cinema
    //surcharge for platinum class cinema
    private double platinumSurcharge;
    //surcharge for gold class cinema
    private double goldSurcharge;

    //customer age groups
    //base price for senior citizens
    private double seniorBasePrice;
    //base price for students
    private double studentBasePrice;
    //base price for adults
    private double adultBasePrice;

    //surcharge for weekend/public holiday screening
    private double weekendPHSurcharge;

    //price constructor
    public Price(double threeDSurcharge, double blkBusterSurcharge, double platinumSurcharge, double goldSurcharge,
            double seniorBasePrice, double studentBasePrice, double adultBasePrice, double weekendPHSurcharge){
                this.threeDSurcharge=threeDSurcharge;
                this.blkBusterSurcharge=blkBusterSurcharge;
                this.platinumSurcharge=platinumSurcharge;
                this.goldSurcharge=goldSurcharge;
                this.seniorBasePrice=seniorBasePrice;
                this.studentBasePrice=studentBasePrice;
                this.adultBasePrice=adultBasePrice;
                this.weekendPHSurcharge=weekendPHSurcharge;
    }

    //getter methods
    public double getThreeDSurcharge(){
        return threeDSurcharge;
    }

    public double getBlkBusterSurcharge(){
        return blkBusterSurcharge;
    }

    public double getPlatinumSurcharge(){
        return platinumSurcharge;
    }

    public double getGoldSurcharge(){
        return goldSurcharge;
    }  
    
    public double getSeniorBasePrice(){
        return seniorBasePrice;
    }

    public double getAdultBasePrice(){
        return adultBasePrice;
    }

    public double getStudentBasePrice(){
        return studentBasePrice;
    }

    public double getWeekendPHSurcharge(){
        return weekendPHSurcharge;
    }

    //setter methods
    public void setThreeDSurcharge(double threeDSurcharge){
        this.threeDSurcharge=threeDSurcharge;
    }

    public void setBlkBusterSurcharge(double blkBusterSurcharge){
        this.blkBusterSurcharge=blkBusterSurcharge;
    }

    public void setPlatinumSurcharge(double platinumSurcharge){
        this.platinumSurcharge=platinumSurcharge;
    }

    public void setGoldSurcharge(double goldSurcharge){
        this.goldSurcharge=goldSurcharge;
    }

    public void setSeniorBasePrice(double seniorBasePrice){
        this.seniorBasePrice=seniorBasePrice;
    }

    public void setAdultBasePrice(double adultBasePrice){
        this.adultBasePrice=adultBasePrice;
    }

    public void setStudentBasePrice(double studentBasePrice){
        this.studentBasePrice=studentBasePrice;
    }

    public void setWeekendPHSurcharge(double weekendPHSurcharge){
        this.weekendPHSurcharge=weekendPHSurcharge;
    }
}
