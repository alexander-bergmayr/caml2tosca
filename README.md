# caml2tosca

Recent efforts in standardizing cloud-oriented software deployments resulted in [TOSCA](http://docs.oasisopen.org/tosca/TOSCA/v1.0/os/TOSCA-v1.0-os.html). At the same time, [UML](http://www.omg.org/spec/UML/) supports modeling software systems from different viewpoints, including the deployment one. Combining these adopted standards brings modeling support to engineers not only to design and deploy software systems but also to operate them because TOSCA-compliant containers, such as [OpenTOSCA](http://www.iaas.uni-stuttgart.de/OpenTOSCA/indexE.php), enable automatic resource provisioning based on deployment models.

With caml2tosca, we provide a model-to-model transformation addressing both the intensional and extensional level of deployment models. Extensions to UML, which we called [CAML](https://github.com/alexander-bergmayr/caml), act as a brigde between the UML and TOSCA.
