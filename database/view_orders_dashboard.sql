CREATE VIEW dashboard_orders AS
    SELECT 
        c.name AS clientName,
        c.cpf AS clientCpf,
        c.cell_phone,
        v.plate,
        v.model,
        v.brand,
        v.color,
        v.year,
        e.name AS employeeName,
        e.cpf AS employeeCpf,
        e.job_title,
        s.name AS serviceName,
        CONCAT('R$ ', b.price_services) AS price_services,
        (SELECT 
                GROUP_CONCAT(CONCAT(prov.name,
                                ': ',
                                prod.name,
                                ' (R$',
                                prod.price,
                                ')')
                        SEPARATOR ' , ')
            FROM
                budget_details bd
                    INNER JOIN
                products prod ON bd.products_id = prod.id
                    INNER JOIN
                providers prov ON prod.providers_id = prov.id
            WHERE
                budget_id = o.budget_id
            GROUP BY budget_id) AS produtos,
        CONCAT('R$ ', b.total_items) AS total_items,
        CONCAT('R$ ', b.total) AS total,
        CONCAT('R$ ', o.discount) AS discount,
        o.date,
        o.payment,
        o.situation
    FROM
        orders o
            INNER JOIN
        employees e ON o.employees_id = e.id
            INNER JOIN
        budget b ON o.budget_id = b.id
            INNER JOIN
        vehicles v ON b.vehicles_id = v.id
            INNER JOIN
        services s ON b.services_id = s.id
            INNER JOIN
        clients c ON b.clients_id = c.id