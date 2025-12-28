/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslogic;
import com.forum.diplomski.data.Diskusija;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Slobodan
 */
public class SocialFeedBuilder {
    private ArrayList<SocialFeedItem> feed;
    private SocialFeedEvaluator sfe;

    public SocialFeedBuilder(ArrayList<Diskusija> feed, Path script) throws IOException {
        this.feed = new ArrayList<SocialFeedItem>();
        
        for(Diskusija d : feed) {
            this.feed.add(new SocialFeedItem(d));
        }
        
        this.sfe = new SocialFeedEvaluator(script);
    }
    
    public void evaluteFeed() throws Exception {
        this.sfe.loadScript();
        
        for(SocialFeedItem sfi : this.feed) {
            double poz = sfe.evalutePosition(sfi.getDiskusija());
            sfi.dodeliPoziciju(poz);
        }
    }
    
    public void sortFeedByRelevancy() throws Exception {
        
        for(int i = 0; i < feed.size() - 1; i++) {
            for(int j = i + 1; j < feed.size(); j++) {
                if(feed.get(j).getPosition() < feed.get(i).getPosition()) {
                    SocialFeedItem temp = feed.get(i);
                    feed.set(i, feed.get(j));
                    feed.set(j, temp);
                }
            }
        }
    }
    
    public ArrayList<Diskusija> vratiFeed() {
        ArrayList<Diskusija> diskusije = new ArrayList<Diskusija>();
        
        for(SocialFeedItem sfi : this.feed) {
            diskusije.add(sfi.getDiskusija());
        }
        
        return diskusije;
    }

    public ArrayList<SocialFeedItem> getFeed() {
        return feed;
    }
}
