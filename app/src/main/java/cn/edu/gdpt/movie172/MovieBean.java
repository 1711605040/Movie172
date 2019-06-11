package cn.edu.gdpt.movie172;

public class MovieBean {
    private  int id;
    private  String movie_name;
    private  int totle_office;
    private  int real_office;
    private  int office_ratio;
    private  int show_rate;
    private  int avg_set_view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getTotle_office() {
        return totle_office;
    }

    public void setTotle_office(int totle_office) {
        this.totle_office = totle_office;
    }

    public int getReal_office() {
        return real_office;
    }

    public void setReal_office(int real_office) {
        this.real_office = real_office;
    }

    public int getOffice_ratio() {
        return office_ratio;
    }

    public void setOffice_ratio(int office_ratio) {
        this.office_ratio = office_ratio;
    }

    public int getShow_rate() {
        return show_rate;
    }

    public void setShow_rate(int show_rate) {
        this.show_rate = show_rate;
    }

    public int getAvg_set_view() {
        return avg_set_view;
    }

    public void setAvg_set_view(int avg_set_view) {
        this.avg_set_view = avg_set_view;
    }
}
