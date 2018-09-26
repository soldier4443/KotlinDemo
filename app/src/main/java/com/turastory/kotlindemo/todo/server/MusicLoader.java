package com.turastory.kotlindemo.todo.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Util class - FILE I/O
 */
public class MusicLoader {
    public static Map<SongInfo, List<String>> loadMusics() {
        Map<SongInfo, List<String>> map = new HashMap<>();
        
        try {
            System.out.println("================================ Initiate import process... ================================");
            BufferedReader br = openFile(new File("/music/music_renewal.csv"));
            
            LyricsReader lyricsReader = new LyricsReader();
            String line;
            
            while (true) {
                line = br.readLine();
                
                if (line != null) {
                    lyricsReader.decodeLine(line);
                } else {
                    // 마지막은 결과가 만들어지지 않은 채로 남아있기 때문에
                    // 직접 결과를 만들어줘야 한다.
                    lyricsReader.yieldResults();
                    break;
                }
            }
            
            map = lyricsReader.getDecodedResults();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return map;
    }
    
    private static BufferedReader openFile(File path) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(path)));
    }
}