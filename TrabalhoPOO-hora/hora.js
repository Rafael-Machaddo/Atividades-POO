
public class Hora extends Object {
    private int ms = 0;
    private int seg = 0;
    private int min = 0;
    private int hrs = 0;
    private int days = 1;
    private boolean nextday = false;

    private int[] formatador() {
        int[] horarioForm = new int[4];

        while(ms >= 1000) {
            seg ++;
            ms = ms - 1000;
        }
        while(seg >= 60) {
            min++;
            seg = seg - 60;
        }
        while(min >= 60) {
            hrs ++;
            min = min - 60;
        }
        while (hrs >= 24) {
            nextday = true;
            days ++;
            hrs = hrs - 24;
        }

        horarioForm[0] = hrs;
        horarioForm[1] = min;
        horarioForm[2] = seg;
        horarioForm[3] = ms;
        return horarioForm;
    }

    public String getHorario() {
        String horario = "";
        for(int i = 0; i < formatador().length; i ++) {
            if(i < formatador().length - 1) {

                if(formatador()[i] < 10) {
                    horario += "0";
                }
                horario += formatador()[i] + ":";
            } else {
                if(formatador()[i] < 10) {
                    horario += "000";
                } else if (formatador()[i] < 100) {
                    horario += "00";
                } else if(formatador()[i] < 1000) {
                    horario += "0";
                }
                horario += formatador()[i];
            }
        }
        if(nextday) {
            horario = "Dias: " + days + ". Horário: " + horario;
        }
        return horario;
    }

    public String getHorarioAmPm() {
        String horarioAmPm = "";
        if(formatador()[0] > 12) {
            horarioAmPm += (formatador()[0] - 12) + "pm";

        } else {
            horarioAmPm += formatador()[0] + "am";
        }
        if(nextday) {
            horarioAmPm = "Dias: " + days + ". Horário: " + horarioAmPm;
        }
        return horarioAmPm;
    }

    public void addHorario(int hrs, int min, int seg, int ms) {
        this.ms += ms;
        this.seg += seg;
        this.min += min;
        this.hrs += hrs;

    }

    public void apagarHorario() {
        this.ms = 0;
        this.seg = 0;
        this.min = 0;
        this.hrs = 0;
        this.days = 0;
        this.nextday = false;

    }

    public long conversorms() {
        int convhrs = this.hrs;
        int convmin = this.min;
        int convseg = this.seg;
        int convms = this.ms;
        convmin += convhrs * 60;
        convseg += convmin * 60;
        convms += convseg * 1000L;

        return convms;
    }

    @Override
    public boolean equals(Object var1) {
        return this.getHorario().equals(((Hora)var1).getHorario());
    }
}