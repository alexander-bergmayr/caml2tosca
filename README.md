# caml2tosca

Recent efforts in standardizing cloud-oriented software deployments resulted in [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html). At the same time, [UML](http://www.omg.org/spec/UML/) supports modeling software systems from different viewpoints, including the deployment one. Combining these adopted standards brings modeling support to engineers not only to design and deploy software systems but also to operate them because [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html)-compliant containers, such as [OpenTOSCA](http://www.iaas.uni-stuttgart.de/OpenTOSCA/indexE.php), enable automatic resource provisioning based on deployment models.

With _caml2tosca_, we provide a model-to-model transformation addressing both the intensional and extensional level of software deployment models. Extensions to UML, which we called [CAML](https://github.com/alexander-bergmayr/caml), act as a brigde between [UML](http://www.omg.org/spec/UML/) and [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html).

To support the translation of [CAML](https://github.com/alexander-bergmayr/caml) models into corresponding [TOSCA](http://docs.oasis-open.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html) models, we have implemented [ATL](https://eclipse.org/atl) transformations on top of the Eclipse environment.
