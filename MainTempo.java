public class MainTempo {
    public static void main(String[] args) {
        Tempo t1 = new Tempo(9, 30, 5);
        System.out.println(t1);
        System.out.println(t1.paraHhmmss());
        System.out.println(t1.paraAmPm());
        System.out.println(new Tempo(0, 15, 0).paraAmPm());
        System.out.println(new Tempo(12, 0, 0).paraAmPm());
        System.out.println(new Tempo(13, 5, 0).paraAmPm());

        Tempo t2 = new Tempo(10, 59, 59);
        t2.acrescentarSegundo();
        System.out.println(t2);

        Tempo t3 = new Tempo(23, 59, 59);
        t3.acrescentarSegundo();
        System.out.println(t3);

        System.out.println(new Tempo(9, 30, 5).diferenca(new Tempo(7, 45, 50)));
    }
}