package tm;

public class IncomeTM {
    private String revenue;
    private Double mIncome;
    private Double yIncome;

    public IncomeTM() {
    }

    public IncomeTM(String revenue, Double mIncome, Double yIncome) {
        this.revenue = revenue;
        this.mIncome = mIncome;
        this.yIncome = yIncome;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public Double getmIncome() {
        return mIncome;
    }

    public void setmIncome(Double mIncome) {
        this.mIncome = mIncome;
    }

    public Double getyIncome() {
        return yIncome;
    }

    public void setyIncome(Double yIncome) {
        this.yIncome = yIncome;
    }

    @Override
    public String toString() {
        return "IncomeTM{" +
                "revenue='" + revenue + '\'' +
                ", mIncome=" + mIncome +
                ", yIncome=" + yIncome +
                '}';
    }
}
