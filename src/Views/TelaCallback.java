package Views;

import com.crud.models.EstoqueModel;
import com.crud.models.ItemModel;

public interface TelaCallback {

    void trocarTela(int idTela);
    boolean InsertItem (ItemModel Item);
    int SolicitarID();


}
