package com.example.am.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private long id_user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_project")
    private List<Criterion> criteria;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_project")
    private List<Alternative> alternatives;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_project")
    private List<Expert> experts;

}
