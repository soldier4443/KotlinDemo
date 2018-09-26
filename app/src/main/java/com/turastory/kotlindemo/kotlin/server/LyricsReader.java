package com.turastory.kotlindemo.kotlin.server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LyricsReader {
    
    private static final int META_INFO_LINES = 2;
    private static final int TITLE_LINE = 0;
    private static final int ARTIST_LINE = 1;
    
    private SongInfo songInfo;
    
    private Map<SongInfo, List<String>> decodedResults;
    private List<String> acc;
    private int metaLineIndex;
    
    public LyricsReader() {
        decodedResults = new HashMap<>();
        acc = new ArrayList<>();
    }
    
    public Map<SongInfo, List<String>> getDecodedResults() {
        return decodedResults;
    }
    
    public void yieldResults() {
        decodedResults.put(songInfo, new ArrayList<>(acc));
        acc.clear();
    }
    
    public void decodeLine(String line) {
        try {
            int difficulty = decodeFirstLineOrThrowException(line.split(","));
            metaLineIndex = 0;
            
            if (!isFirstDecode())
                yieldResults();
            
            songInfo = new SongInfo();
            songInfo.setDifficulty(difficulty);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            if (metaLineIndex < META_INFO_LINES) {
                decodeMetaLine(line);
                metaLineIndex++;
            } else {
                decodeLyricLine(line);
            }
        }
    }
    
    private int decodeFirstLineOrThrowException(String[] firstLine) throws NumberFormatException {
        return Integer.parseInt(firstLine[1]);
    }
    
    private boolean isFirstDecode() {
        return songInfo == null;
    }
    
    private void decodeMetaLine(String line) {
        if (metaLineIndex == TITLE_LINE) {
            songInfo.setTitle(line.trim());
        } else if (metaLineIndex == ARTIST_LINE) {
            songInfo.setArtist(getArtist(line));
        }
    }
    
    private void decodeLyricLine(String line) {
        acc.add(line.trim());
    }
    
    private String getArtist(String stringContainsArtist) {
        String artist = stringContainsArtist;
        String[] interSplits = stringContainsArtist.split(",");
        
        for (int i = 0; i < interSplits.length; i++) {
            String interSplit = interSplits[i];
            
            if (interSplit.contains("노래")) {
                artist = interSplit.replace("노래", "").trim();
                break;
            }
        }
        
        return artist;
    }
}
