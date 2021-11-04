package com.stefanmocoat.showoffice.ui.views.pferde;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;

import com.stefanmocoat.showoffice.jpa.entities.Pferd;
import com.stefanmocoat.showoffice.service.PferdService;
import com.stefanmocoat.showoffice.ui.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Pferde")
@Route(value = "pferde/:samplePferdID?/:action?(edit)", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class PferdeView extends Div implements BeforeEnterObserver {

	private final String SAMPLEPFERD_ID = "samplePferdID";
	private final String SAMPLEPFERD_EDIT_ROUTE_TEMPLATE = "pferde/%d/edit";

	private Grid<Pferd> grid = new Grid<>(Pferd.class, false);

	private TextField kopfnummer;
	private TextField pferdename;
	private TextField lebensnummer;
	private TextField geschlecht;
	private TextField gebJahr;
	private TextField occupation;

	private Button cancel = new Button("Cancel");
	private Button save = new Button("Save");

	private BeanValidationBinder<Pferd> binder;

	private Pferd samplePferd;

	private PferdService samplePferdService;

	public PferdeView(@Autowired PferdService samplePferdService) {
		this.samplePferdService = samplePferdService;
		addClassNames("pferde-view", "flex", "flex-col", "h-full");
		// Create UI
		SplitLayout splitLayout = new SplitLayout();
		splitLayout.setSizeFull();

		createGridLayout(splitLayout);
		createEditorLayout(splitLayout);

		add(splitLayout);

		// Configure Grid
		grid.addColumn("kopfnummer").setAutoWidth(true);
		grid.addColumn("pferdename").setAutoWidth(true);
		grid.addColumn("lebensnummer").setAutoWidth(true);
		grid.addColumn("geschlecht").setAutoWidth(true);
		grid.addColumn("gebJahr").setAutoWidth(true);
		grid.addColumn("farbe").setAutoWidth(true);
//        TemplateRenderer<Pferd> importantRenderer = TemplateRenderer.<Pferd>of(
//                "<iron-icon hidden='[[!item.important]]' icon='vaadin:check' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);'></iron-icon><iron-icon hidden='[[item.important]]' icon='vaadin:minus' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);'></iron-icon>")
//                .withProperty("important", Pferd::isImportant);
//        grid.addColumn(importantRenderer).setHeader("Important").setAutoWidth(true);

		grid.setDataProvider(new CrudServiceDataProvider<>(samplePferdService));
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
		grid.setHeightFull();

		// when a row is selected or deselected, populate form
		grid.asSingleSelect().addValueChangeListener(event -> {
			if (event.getValue() != null) {
				UI.getCurrent().navigate(String.format(SAMPLEPFERD_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
			} else {
				clearForm();
				UI.getCurrent().navigate(PferdeView.class);
			}
		});

		// Configure Form
		binder = new BeanValidationBinder<>(Pferd.class);

		// Bind fields. This where you'd define e.g. validation rules

		binder.bindInstanceFields(this);

		cancel.addClickListener(e -> {
			clearForm();
			refreshGrid();
		});

		save.addClickListener(e -> {
			try {
				if (this.samplePferd == null) {
					this.samplePferd = new Pferd();
				}
				binder.writeBean(this.samplePferd);

				samplePferdService.update(this.samplePferd);
				clearForm();
				refreshGrid();
				Notification.show("Pferd details stored.");
				UI.getCurrent().navigate(PferdeView.class);
			} catch (ValidationException validationException) {
				Notification.show("An exception happened while trying to store the samplePferd details.");
			}
		});

	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		Optional<Integer> samplePferdId = event.getRouteParameters().getInteger(SAMPLEPFERD_ID);
		if (samplePferdId.isPresent()) {
			Optional<Pferd> samplePferdFromBackend = samplePferdService.get(samplePferdId.get());
			if (samplePferdFromBackend.isPresent()) {
				populateForm(samplePferdFromBackend.get());
			} else {
				Notification.show(
						String.format("The requested samplePferd was not found, ID = %d", samplePferdId.get()), 3000,
						Notification.Position.BOTTOM_START);
				// when a row is selected but the data is no longer available,
				// refresh grid
				refreshGrid();
				event.forwardTo(PferdeView.class);
			}
		}
	}

	private void createEditorLayout(SplitLayout splitLayout) {
		Div editorLayoutDiv = new Div();
		editorLayoutDiv.setClassName("flex flex-col");
		editorLayoutDiv.setWidth("400px");

		Div editorDiv = new Div();
		editorDiv.setClassName("p-l flex-grow");
		editorLayoutDiv.add(editorDiv);

		FormLayout formLayout = new FormLayout();
		kopfnummer = new TextField("kopfnummer");
		pferdename = new TextField("pferdename");
		lebensnummer = new TextField("lebensnummer");
		geschlecht = new TextField("geschlecht");
		gebJahr = new TextField("gebJahr");
		occupation = new TextField("Occupation");
		Component[] fields = new Component[] { kopfnummer, pferdename, lebensnummer, geschlecht, gebJahr, occupation };

		for (Component field : fields) {
			((HasStyle) field).addClassName("full-width");
		}
		formLayout.add(fields);
		editorDiv.add(formLayout);
		createButtonLayout(editorLayoutDiv);

		splitLayout.addToSecondary(editorLayoutDiv);
	}

	private void createButtonLayout(Div editorLayoutDiv) {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
		buttonLayout.setSpacing(true);
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonLayout.add(save, cancel);
		editorLayoutDiv.add(buttonLayout);
	}

	private void createGridLayout(SplitLayout splitLayout) {
		Div wrapper = new Div();
		wrapper.setId("grid-wrapper");
		wrapper.setWidthFull();
		splitLayout.addToPrimary(wrapper);
		wrapper.add(grid);
	}

	private void refreshGrid() {
		grid.select(null);
		grid.getDataProvider().refreshAll();
	}

	private void clearForm() {
		populateForm(null);
	}

	private void populateForm(Pferd value) {
		this.samplePferd = value;
		binder.readBean(this.samplePferd);

	}
}
