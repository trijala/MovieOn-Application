package MovieOn.db.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "favorites")

public class Favorites {
    @Id
    @GeneratedValue
    private Long favId;
    private Long userId;
    private Long movieId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @OneToOne
    @JoinColumn(updatable=false,insertable=false,name = "movieId",referencedColumnName = "id")
    Movie movie;

    @OneToOne
    @JoinColumn(updatable=false,insertable=false,name = "userId",referencedColumnName = "userId")
    Users user;

    @Column(name = "isTrue")
    Boolean isFavorite;

    public Long getFavId() {
        return favId;
    }

    public void setFavId(Long favId) {
        this.favId = favId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}
