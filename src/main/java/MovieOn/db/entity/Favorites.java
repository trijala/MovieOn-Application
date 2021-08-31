package MovieOn;



import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "Favorites")

public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    Long movie_Id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "movie_id")
    Movie movie;

    @Column(name = "isTrue")
    Boolean isFavorite;

    public Long getMovie_Id() {
        return movie_Id;
    }

    public void setMovie_Id(Long movie_Id) {
        this.movie_Id = movie_Id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }
}
