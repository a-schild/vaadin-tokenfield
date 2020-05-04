package org.aarboard.tokenfield.widgetset.client.ui;


import com.google.gwt.core.client.GWT;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.shared.ui.Connect;
import com.vaadin.v7.client.ui.combobox.ComboBoxConnector;
import org.aarboard.tokenfield.TokenComboBox;
import org.aarboard.tokenfield.widgetset.client.ui.VTokenField.DeleteListener;


@Connect(TokenComboBox.class)
public class TokenFieldConnector extends ComboBoxConnector {

    private TokenFieldServerRpc rpc = RpcProxy.create(
            TokenFieldServerRpc.class, this);

    protected boolean after = false;

    @Override
    protected void init() {
        getWidget().addListener(new DeleteListener() {
            public void onDelete() {
                rpc.deleteToken();
            }
        });

    }

    @Override
    public VTokenField getWidget() {
        return (VTokenField) super.getWidget();
    }

    @Override
    protected VTokenField createWidget() {
        // TODO Auto-generated method stub
        return GWT.create(VTokenField.class);
    }

}
