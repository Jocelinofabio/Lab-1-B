public class Tempo {

    private int hora, minuto, segundo;

    public Tempo() { this(0, 0, 0); }
    public Tempo(int h) { this(h, 0, 0); }
    public Tempo(int h, int m) { this(h, m, 0); }
    public Tempo(int h, int m, int s) {
        this.hora = (h >= 0 && h <= 23) ? h : 0;
        this.minuto = (m >= 0 && m <= 59) ? m : 0;
        this.segundo = (s >= 0 && s <= 59) ? s : 0;
    }

    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getSegundo() { return segundo; }

    public boolean setHora(int h) { if (h < 0 || h > 23) return false; hora = h; return true; }
    public boolean setMinuto(int m) { if (m < 0 || m > 59) return false; minuto = m; return true; }
    public boolean setSegundo(int s) { if (s < 0 || s > 59) return false; segundo = s; return true; }

    public String paraHhmmss() { return String.format("%02d%02d%02d", hora, minuto, segundo); }

    public String paraAmPm() {
        int h = hora % 12 == 0 ? 12 : hora % 12;
        return String.format("%02d:%02d:%02d %s", h, minuto, segundo, hora < 12 ? "AM" : "PM");
    }

    public void acrescentarSegundo() {
        segundo++;
        if (segundo == 60) { segundo = 0; minuto++; }
        if (minuto == 60) { minuto = 0; hora++; }
        if (hora == 24) hora = 0;
    }

    public int emSegundos() { return hora * 3600 + minuto * 60 + segundo; }

    public static Tempo deSegundos(int total) {
        total = Math.abs(total);
        return new Tempo((total / 3600) % 24, (total % 3600) / 60, total % 60);
    }

    public Tempo diferenca(Tempo outro) { return Tempo.deSegundos(Math.abs(this.emSegundos() - outro.emSegundos())); }

    @Override public String toString() { return String.format("%02d:%02d:%02d", hora, minuto, segundo); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tempo)) return false;
        Tempo o = (Tempo) obj;
        return hora == o.hora && minuto == o.minuto && segundo == o.segundo;
    }

    @Override public int hashCode() { return emSegundos(); }
}