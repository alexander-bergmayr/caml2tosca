# caml2tosca

Recent efforts in standardizing cloud-oriented software deployments resulted in [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html). At the same time, [UML](http://www.omg.org/spec/UML/) supports modeling software systems from different viewpoints, including the deployment one. Combining these adopted standards brings modeling support to engineers not only to design and deploy software systems but also to operate them because [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html)-compliant containers, such as [OpenTOSCA](http://www.iaas.uni-stuttgart.de/OpenTOSCA/indexE.php), enable automatic resource provisioning based on deployment models.

With _caml2tosca_, we provide a model-to-model transformation addressing both the intensional and extensional level of software deployment models. Extensions to UML, which we called [CAML](https://github.com/alexander-bergmayr/caml), act as a brigde between [UML](http://www.omg.org/spec/UML/) and [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html).

To support the translation of [CAML](https://github.com/alexander-bergmayr/caml) models into corresponding [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html) models, we have implemented [ATL](https://eclipse.org/atl) transformations on top of the Eclipse environment.

The transformations are located in this [project](https://github.com/alexander-bergmayr/caml2tosca/tree/master/projects/eu.artist.migration.deployment.caml2tosca). The Ecore-based metamodel of [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html) can be found [here](https://github.com/alexander-bergmayr/caml2tosca/tree/master/projects/eu.artist.migration.deployment.tosca). UI support to run the transformation is provided by this [project](https://github.com/alexander-bergmayr/caml2tosca/tree/master/projects/eu.artist.migration.deployment.caml2tosca.ui). Example models are located in this [project](https://github.com/alexander-bergmayr/caml2tosca/tree/master/projects/eu.artist.migration.deployment.model). Finally, the respective Eclipse-plugins can be found [here](https://github.com/alexander-bergmayr/caml2tosca/tree/master/plugins).

To learn how to execute the transformations, visit the [Wiki](https://github.com/alexander-bergmayr/caml2tosca/wiki/Main).

External resources
This work is part of the [ARTIST](www.artist-project.eu) project.
Repository of the [OpenTOSCA](https://github.com/opentosca) ecosystem.
[Winery](https://projects.eclipse.org/projects/soa.winery) is a TOSCA modeling environment.
We have used [Papyrus](https://www.eclipse.org/papyrus/) to model UML/CAML deployment models.
