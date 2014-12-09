package it.helpdesk.ui.desktop.swing;

import it.helpdesk.datasources.hibernate.HibernateDatasourceConfiguration;
import it.helpdesk.ui.interfaces.IDatasourceConfiguration;

import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class PreloadConnectionDialog extends SwingWorker<Integer, Integer> {
	private JDialog parent;
	private JDialog dialog;
	private JProgressBar progressBar = new JProgressBar();

	public PreloadConnectionDialog(JDialog parent) {
		this.parent = parent;
		progressBar.setString("Waiting on database connection.");
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(true);
		dialog = new JDialog(parent, "Connecting...", true);
		dialog.getContentPane().add(progressBar);
		dialog.pack();
		
	}

	@Override
	protected Integer doInBackground() throws Exception {
		parent.setEnabled(false);
		dialog.requestFocus();
		dialog.setModal(false);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setLocationRelativeTo(parent);
		dialog.setVisible(true);
		IDatasourceConfiguration datasourceConfiguration = new HibernateDatasourceConfiguration();
		datasourceConfiguration.getTechnicianDatasource().checkPassword("", "");
		parent.setEnabled(true);
		parent.requestFocus();
		return 0;
	}

	@Override
	protected void done() {
		dialog.dispose();
	}
	
	public JDialog getDialogObject() {
		return this.dialog;
	}
}
