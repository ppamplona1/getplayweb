/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brunocosta
 */
@Entity
@Table(name = "PLAYLISTS")
@XmlRootElement

public class Playlist implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(unique = true,name = "PLAYLIST_ID")
    private Long playlistID;
    
    @NotNull
    @Column(name = "NAME") 
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    
    @OneToOne
    @JoinColumn(name ="USER_ID", nullable = false)
    private User user;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="SONG_ID", nullable = false)
    private List<Music> songs;

    
    public Long getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(Long playlistID) {
        this.playlistID = playlistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Music> getSongs() {
        return songs;
    }

    public void setSongs(List<Music> songs) {
        this.songs = songs;
    }

    
    
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playlistID != null ? playlistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the playlistID fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.playlistID == null && other.playlistID != null) || (this.playlistID != null && !this.playlistID.equals(other.playlistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Playlist[ id=" + playlistID + " ]";
    }
    
}
