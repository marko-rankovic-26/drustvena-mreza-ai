/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslogic;

import com.forum.diplomski.data.Diskusija;
import java.io.IOException;
import java.nio.file.Path;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author Slobodan
 */
public class SocialFeedEvaluator {
    private Path path;
    private FIS fis;

    public SocialFeedEvaluator(Path path) throws IOException {
        this.path = path;
    }
    
    public void loadScript() throws Exception {
        this.fis = FIS.load(this.path.toString(), true);
    }
    
    public double evalutePosition(Diskusija diskusija) throws ScriptNotLoadedException {
        double position = 0;
        
        if(fis == null)
            throw new ScriptNotLoadedException(path.getFileName().toString());
        
        FunctionBlock fb = fis.getFunctionBlock(null);
        
        // OBRATITI PAZNJU AKO JE VREDNOST PARAMETRA VECA OD 50!!!!
        fb.setVariable("lajkovi", calibrateInputValues(diskusija.getLajkovi()));
        fb.setVariable("dislajkovi", calibrateInputValues(diskusija.getDislajkovi()));
        fb.setVariable("komentari", calibrateInputValues(diskusija.getBrojKom()));
        
        // RADI TESTA SVE JE POMNOZENO SA KOEFICIJENTOM 5!!!!!
//        if(diskusija.getDiskid() == 7) {
//            fb.setVariable("lajkovi", 40);
//            fb.setVariable("dislajkovi", 27);
//            fb.setVariable("komentari", 35);
//        }
//        else {
//            fb.setVariable("lajkovi", diskusija.getLajkovi());
//            fb.setVariable("dislajkovi", diskusija.getDislajkovi());
//            fb.setVariable("komentari", diskusija.getBrojKom());
//        }
        
        fb.evaluate();
        
        Variable feed = fb.getVariable("feed");
        position = feed.getValue();
        
        return 100.0f - position;
    }
    
    private int calibrateInputValues(int val) {
        return val > 50 ? 50 : val;
    }
}
