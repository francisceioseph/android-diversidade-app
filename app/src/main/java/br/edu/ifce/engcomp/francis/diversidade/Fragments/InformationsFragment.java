package br.edu.ifce.engcomp.francis.diversidade.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.ifce.engcomp.francis.diversidade.R;
import br.edu.ifce.engcomp.francis.diversidade.adapters.HoursRecyclerViewAdapter;
import br.edu.ifce.engcomp.francis.diversidade.adapters.ServicesRecyclerViewAdapter;
import br.edu.ifce.engcomp.francis.diversidade.model.HourNucleus;
import br.edu.ifce.engcomp.francis.diversidade.model.Nucleus;
import br.edu.ifce.engcomp.francis.diversidade.model.Service;

/**
 * Created by Bolsista on 29/03/2016.
 */
public class InformationsFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<HourNucleus> dataSource;

    Nucleus nucleus;
    TextView responsavel;
    TextView telefone;
    TextView email;
    TextView site;
    TextView logradouro;
    TextView bairroCidade;
    TextView estadoPais;

    public InformationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informations, container, false);

        responsavel = (TextView) view.findViewById(R.id.information_responsible_text_view);
        telefone  = (TextView) view.findViewById(R.id.information_phone_text_view);
        email  = (TextView) view.findViewById(R.id.information_email_text_view);
        site  = (TextView) view.findViewById(R.id.information_site_text_view);
        logradouro  = (TextView) view.findViewById(R.id.street_text_view);
        bairroCidade  = (TextView) view.findViewById(R.id.neighborhood_and_city_text_view);
        estadoPais  = (TextView) view.findViewById(R.id.state_and_country_text_view);

        Intent currentIntent = getActivity().getIntent();
        nucleus = (Nucleus) currentIntent.getSerializableExtra("INFOS_NUCLEUS");

        responsavel.setText(R.string.nucleus_responsible + nucleus.getResponsible());
        telefone.setText(nucleus.getPhone());
        email.setText(nucleus.getEmail());
        site.setText(nucleus.getSite());

        logradouro.setText(nucleus.getAddress().getLogradouro() + ", " + nucleus.getAddress().getNumber());
        bairroCidade.setText(nucleus.getAddress().getNeighborhood() + ", " + nucleus.getAddress().getCity());
        estadoPais.setText(nucleus.getAddress().getState() + " - " + nucleus.getAddress().getCountry());

        dataSource = nucleus.getHour();
        //dataSource.add(new HourNucleus("segunda", "19h"));

        HoursRecyclerViewAdapter adapter = new HoursRecyclerViewAdapter(getActivity().getApplicationContext(), dataSource);
        this.layoutManager = new LinearLayoutManager(getActivity());

        this.recyclerView = (RecyclerView) view.findViewById(R.id.hours_nucleus_list);
        this.recyclerView.setHasFixedSize(false);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

}
