package net.opensg.tcs.multiedit.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class ContEditor extends EditorPart {

	public static final String ID = "net.opensg.tcs.multiedit.views.ContEditor"; //$NON-NLS-1$

	private Display display = null;
	private TableViewer tableViewer = null;
	private Table table;

	public ContEditor() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		this.display = parent.getDisplay();
		parent.setLayout(new GridLayout(1, false));

		// (1) Create Table
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		// (2) Create Columns
		TableViewerColumn viewerColName = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblColName = viewerColName.getColumn();
		tblColName.setWidth(150);
		tblColName.setText("Name");
		
		TableViewerColumn viewerColEmail = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblColEmail = viewerColEmail.getColumn();
		tblColEmail.setWidth(150);
		tblColEmail.setText("E-Mail");

		TableViewerColumn viewerColPhone = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblColPhone = viewerColPhone.getColumn();
		tblColPhone.setWidth(150);
		tblColPhone.setText("Phone");

		tableViewer.setContentProvider(new ContEditorContentProvider());
		tableViewer.setLabelProvider(new ContEditorLabelProvider());
	}

	public void BindData(Object data) {
		tableViewer.setInput(data);
	}

	
	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

}
