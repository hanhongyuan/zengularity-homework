package fr.antoinecheron.zenelectricity.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by antoine on 31/08/2017.
 */
public class ProductionEvent extends ResourceSupport implements Comparable<ProductionEvent> {

    // Attributes
    @Id
    private String id;
    private long timestamp;
    private final boolean producing;
    private final String owningPowerPlant;
    private int powerPlantCharge;

    // Constructor
    @JsonCreator
    public ProductionEvent(@JsonProperty(value="producing") boolean producing,
                    @JsonProperty(value="owningPowerPlant") String owningPowerPlant) {

        this.producing = producing;
        this.owningPowerPlant = owningPowerPlant;
        this.timestamp = System.currentTimeMillis() / 1000L;
    }

    // Accessors

    public String getproductionEventId () {
        return this.id;
    }

    public long getTimestamp () {
        return this.timestamp;
    }

    public void setTimetstamp (long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isProducing () {
        return producing;
    }

    public String getOwningPowerPlant () {
        return this.owningPowerPlant;
    }

    public int getPowerPlantCharge () {
        return this.powerPlantCharge;
    }

    public void setPowerPlantCharge (int charge) {
        if (charge >= 0 && charge <= 100) {
            this.powerPlantCharge = charge;
        }
    }

    @Override
    public int compareTo(ProductionEvent o) {
        return this.timestamp > o.getTimestamp() ? 1 : -1;
    }
}
