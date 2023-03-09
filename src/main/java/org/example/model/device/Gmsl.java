
package org.example.model.device;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gmsl {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    @SerializedName("gsm.operator.iso-country")
    public String gsmoperatorisocountry;

    @SerializedName("gsm.network.type")
    public String gsmnetworktype;
    @SerializedName("gsm.sim.state")
    public String gsmsimstate;
    @SerializedName("gsm.operator.alpha")
    public String gsmoperatoralpha;
    @SerializedName("gsm.operator.numeric")
    public String gsmoperatornumeric;


}