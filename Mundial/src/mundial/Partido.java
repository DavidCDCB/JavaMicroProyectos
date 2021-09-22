
package mundial;


public class Partido {
       private String Equipo1;
       private String Equipo2;
       private String gol1;
       private String gol2;
       private String TarA;
       private String TarR;
       private String Tie;

       public Partido() {
       }

       public Partido(String Equipo1, String Equipo2, String gol1, String gol2, String TarA, String TarR, String Tie) {
              this.Equipo1 = Equipo1;
              this.Equipo2 = Equipo2;
              this.gol1 = gol1;
              this.gol2 = gol2;
              this.TarA = TarA;
              this.TarR = TarR;
              this.Tie = Tie;
       }

       public String getEquipo1() {
              return Equipo1;
       }

       public void setEquipo1(String Equipo1) {
              this.Equipo1 = Equipo1;
       }

       public String getEquipo2() {
              return Equipo2;
       }

       public void setEquipo2(String Equipo2) {
              this.Equipo2 = Equipo2;
       }

       public String getGol1() {
              return gol1;
       }

       public void setGol1(String gol1) {
              this.gol1 = gol1;
       }

       public String getGol2() {
              return gol2;
       }

       public void setGol2(String gol2) {
              this.gol2 = gol2;
       }

       public String getTarA() {
              return TarA;
       }

       public void setTarA(String TarA) {
              this.TarA = TarA;
       }

       public String getTarR() {
              return TarR;
       }

       public void setTarR(String TarR) {
              this.TarR = TarR;
       }

       public String getTie() {
              return Tie;
       }

       public void setTie(String Tie) {
              this.Tie = Tie;
       }

      
       
       
}
