/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Unlike us
 */
import java.util.ArrayList;
import java.util.Collections;
import kuva.Fotari;
import kuva.Kuva;

public class Yhdistin {

    private String kuidassalv;
    private ArrayList<Kuva> pildid;

    public Yhdistin(String kuidas) {
        this.kuidassalv = kuidas;
        this.pildid = new ArrayList<Kuva>();
    }

    public ArrayList lataaKuvat(ArrayList<String> sijainnit) {
        for (String i : sijainnit) {
            Kuva kuva = Fotari.lataa(i);
            pildid.add(kuva);
        }
        return pildid;
    }

    public Kuva yhdistaKuvat(ArrayList<Kuva> vasja) {
        int laius = vasja.get(0).getLeveys();
        int korgus = vasja.get(0).getKorkeus();
        Kuva uusikuva = new Kuva(laius, korgus);
        if ("vaalein".equals(this.kuidassalv)) {
            Kuva kuva = vasja.get(0);

            int x = 0;

            while (x < kuva.getLeveys()) {
                int y = 0;
                while (y < kuva.getKorkeus()) {
                    int maxpunane = 0;
                    int maxsinine = 0;
                    int maxvihrea = 0;
                    for (Kuva j : vasja) {
                        if (j.punainen(x, y) > maxpunane) {
                            maxpunane = j.punainen(x, y);
                        }
                        if (j.sininen(x, y) > maxsinine) {
                            maxsinine = j.sininen(x, y);
                        }
                        if (j.vihrea(x, y) > maxvihrea) {
                            maxvihrea = j.vihrea(x, y);
                        }

                    }

                    uusikuva.asetaVari(x, y, maxpunane, maxvihrea, maxsinine);

                    y++;
                }
                x++;
            }
            return uusikuva;
        } else if ("tummin".equals(this.kuidassalv)) {
            Kuva kuva = vasja.get(0);

            int x = 0;

            while (x < kuva.getLeveys()) {
                int y = 0;
                while (y < kuva.getKorkeus()) {
                    int minpunane = 255;
                    int minsinine = 255;
                    int minvihrea = 255;
                    for (Kuva j : vasja) {
                        if (j.punainen(x, y) < minpunane) {
                            minpunane = j.punainen(x, y);
                        }
                        if (j.sininen(x, y) < minsinine) {
                            minsinine = j.sininen(x, y);
                        }
                        if (j.vihrea(x, y) < minvihrea) {
                            minvihrea = j.vihrea(x, y);
                        }

                    }

                    uusikuva.asetaVari(x, y, minpunane, minvihrea, minsinine);

                    y++;
                }
                x++;
            }
            return uusikuva;
        } else if ("mediaani".equals(this.kuidassalv)) {
            ArrayList<Integer> varilistasini = new ArrayList<>();
            ArrayList<Integer> varilistapuna = new ArrayList<>();
            ArrayList<Integer> varilistavihrea = new ArrayList<>();

            Kuva kuva = vasja.get(0);

            int x = 0;

            while (x < kuva.getLeveys()) {
                int y = 0;
                int medpunane = kuva.punainen(x, y);
                int medvihrea = kuva.vihrea(x, y);
                int medsinine = kuva.sininen(x, y);
                while (y < kuva.getKorkeus()) {

                    for (Kuva j : vasja) {

                        varilistasini.add(j.sininen(x, y));
                        varilistapuna.add(j.punainen(x, y));
                        varilistavihrea.add(j.vihrea(x, y));

                    }
                    Collections.sort(varilistasini);
                    medsinine = varilistasini.get(varilistasini.size() / 2);
                    varilistasini.clear();
                    Collections.sort(varilistavihrea);
                    medvihrea = varilistavihrea.get(varilistavihrea.size() / 2);
                    varilistavihrea.clear();
                    Collections.sort(varilistapuna);
                    medpunane = varilistapuna.get(varilistapuna.size() / 2);
                    varilistapuna.clear();

                    uusikuva.asetaVari(x, y, medpunane, medvihrea, medsinine);

                    y++;
                }
                x++;
            }

            return uusikuva;
        }
        return null;
    }
}