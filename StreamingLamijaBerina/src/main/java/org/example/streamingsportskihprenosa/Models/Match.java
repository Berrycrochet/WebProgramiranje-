
package org.example.streamingsportskihprenosa.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Match {

    private Long id;
    private String title;
    private LocalDateTime startTime;
    private String streamUrl;
    private boolean streaming;

    private List<Team> teams = new ArrayList<>();

    public Match(Long id, String title, LocalDateTime startTime, String streamUrl) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.streamUrl = streamUrl;
        this.streaming = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }
}
