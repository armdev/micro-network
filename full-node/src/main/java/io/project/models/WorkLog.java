/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author armenar
 */
@Document(collection = "worklog")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkLog {   
    
    @Id
    private long id;

    @Indexed(unique = true)
    private String worklog;

    private boolean approved;
    
}
