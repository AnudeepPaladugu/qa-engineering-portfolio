# Postman collection verification

The final exported collection was run through Postman's official Newman 6.2.1 runner: **9 requests, 40 assertions, 0 failures**. results.json includes actual transport/body values, assertion names, timing and a SHA-256 of the executed collection. Manual import/execution in the Postman GUI was not verified.

Two initial attempts had nine test-script errors each and zero executed assertions. Those are retained in initial-script-failures.json and explained by QA-PM-001. They are not relabeled as passes.
