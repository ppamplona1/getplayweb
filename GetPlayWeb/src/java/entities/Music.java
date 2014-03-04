/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "MUSIC")
@XmlRootElement
public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
      
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, name = "SONG_ID")
    private Long songID;
    
    @Column(name = "TITLE")
    @NotNull
    @Size(max = 255)
    private String title;
    
    @Column(name = "ARTIST")
    @NotNull
    @Size(max = 45)
    private String artist;
    
    @Column(name = "ALBUM")
    @NotNull
    @Size(max = 45)
    private String album;

    @Column(name = "RELEASEYEAR")
    @NotNull
    private int releaseYEAR;
    
    @Column(name = "PATH")
    @NotNull
    private String path1;

    
    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    
   
    
    
    public Long getSongID() {
        return songID;
    }

    public void setSongID(Long songID) {
        this.songID = songID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
   
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


    public int getReleaseYEAR() {
        return releaseYEAR;
    }

    public void setReleaseYEAR(int releaseYEAR) {
        this.releaseYEAR = releaseYEAR;
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songID != null ? songID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the songID fields are not set
        if (!(object instanceof Music)) {
            return false;
        }
        Music other = (Music) object;
        if ((this.songID == null && other.songID != null) || (this.songID != null && !this.songID.equals(other.songID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Music[ id=" + songID + " ]";
    }
    
}
