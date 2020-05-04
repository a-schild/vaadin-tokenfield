package org.aarboard.tokenfield;


import com.vaadin.server.PaintException;
import com.vaadin.server.PaintTarget;
import com.vaadin.v7.ui.ComboBox;
import org.aarboard.tokenfield.widgetset.client.ui.TokenFieldServerRpc;


public abstract class TokenComboBox extends ComboBox {

    private static final long serialVersionUID = 8382983756053298383L;

    protected TokenField.InsertPosition insertPosition;

    private TokenFieldServerRpc rpc = new TokenFieldServerRpc() {
        public void deleteToken() {
            onDelete();
        }
    };

    public TokenComboBox(TokenField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        registerRpc(rpc);
    }

    @Override
    public void paintContent(PaintTarget target) throws PaintException {
        super.paintContent(target);
        target.addVariable(this, "del", false);
        if (insertPosition == TokenField.InsertPosition.AFTER) {
            target.addAttribute("after", true);
        }
    }

    public void setTokenInsertPosition(TokenField.InsertPosition insertPosition) {
        this.insertPosition = insertPosition;
        requestRepaint();
    }

    abstract protected void onDelete();

}
