package cn.edu.gdpt.movie172;

public class MovieBean {
    private  String movie_name;
    private  int daysOfHK;
    private  int sumOfWeekHK;
    private  int weekPeriodOfHK;

    public MovieBean(String movie_name, int daysOfHK, int sumOfWeekHK, int weekPeriodOfHK) {
        this.movie_name = movie_name;
        this.daysOfHK = daysOfHK;
        this.sumOfWeekHK = sumOfWeekHK;
        this.weekPeriodOfHK = weekPeriodOfHK;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getDaysOfHK() {
        return daysOfHK;
    }

    public void setDaysOfHK(int daysOfHK) {
        this.daysOfHK = daysOfHK;
    }

    public int getSumOfWeekHK() {
        return sumOfWeekHK;
    }

    public void setSumOfWeekHK(int sumOfWeekHK) {
        this.sumOfWeekHK = sumOfWeekHK;
    }

    public int getWeekPeriodOfHK() {
        return weekPeriodOfHK;
    }

    public void setWeekPeriodOfHK(int weekPeriodOfHK) {
        this.weekPeriodOfHK = weekPeriodOfHK;
    }
}
