package com.example.Demomongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;


@Data
@Document(collection = "Docgia")
public class DocgiaEntity {

    @Id
    private String id;
    private Date ngaysinh;
    private String gioitinh;
    private String diachi;
    private String email;

}
