package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerDistanceAux;

import java.util.List;

public interface VolunteerDistanceAuxRepository{
    public List<VolunteerDistanceAux> volunteerDistance(double latitude, double longitude, long number);
}