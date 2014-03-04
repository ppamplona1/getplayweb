/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author brunocosta
 */
@Entity
@Table(name = "USERS")
@XmlRootElement

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(unique = true,name = "USER_ID")
    private Long userID;
    
    @NotNull
    @Column(name = "NAME") 
    @Size(max = 100)
    private String name;
    
    @NotNull
    @Column(name = "E_MAIL") 
    @Size(max = 100)
    @Pattern(regexp="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+"
            + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message= "{invalid e-mail}")
    private String eMail;
    
    @NotNull
    @Column(name = "PASSWORD") 
    @Size(min = 4, max = 20)
    private String password;
    
//    @OneToMany(mappedBy = "SONG_ID")
//    private List<Music> userMusic;
//    
//    @OneToMany(mappedBy = "PLAYLIST_ID")
//    private List<Playlist> userPlaylist;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the userID fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + userID + " ]";
    }
    
}
